package main

import (
    "fmt"
    "html/template"
    "log"
    "net/http"
    "gopkg.in/mgo.v2"
)

type Route struct {
  Participant   string
  RouteType     string
  Difficulty    string
  Color         string
  Comments      string
}

func logRoute(httpWriter http.ResponseWriter, request *http.Request) {
    if request.Method == "GET" {
        form, _ := template.ParseFiles("new_route.gtpl")
        form.Execute(httpWriter, nil)
    } else {
        // Build the Route Info
        completed_route := Route{
          Participant: request.FormValue("participant"),
          RouteType: request.FormValue("routeType"),
          Difficulty: request.FormValue("difficulty"),
          Color: request.FormValue("color"),
          Comments: request.FormValue("comments")}

        // Save this to the database...
        session, err := mgo.Dial("localhost:27017")
        if err != nil {
            panic(err)
        }
        defer session.Close()
        collection := session.DB("rock-climbing").C("logs")
        err = collection.Insert(completed_route)
        if err != nil {
            log.Fatal(err)
        }

        // Then show the user what they submitted.

        loggedRoutePage, _ := template.ParseFiles("logged_route.gtpl")
        loggedRoutePage.Execute(httpWriter, completed_route)
    }
}

func main() {
    // Handle log_route Page
    http.HandleFunc("/log_route", logRoute)

    // Handle Static Requests
    fs := http.FileServer(http.Dir("."))
    http.Handle("/", fs)

    fmt.Println("Serving on port :9090")
    err := http.ListenAndServe(":9090", nil) // setting listening port
    if err != nil {
        log.Fatal("ListenAndServe: ", err)
    }
}
