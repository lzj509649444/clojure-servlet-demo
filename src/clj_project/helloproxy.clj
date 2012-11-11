(ns clj-project.helloproxy
  (:use clj-project.helloservlet))

(defn servlet []
  (proxy [javax.servlet.http.HttpServlet] []
    (doGet [request response] (-doGet this request response))))
