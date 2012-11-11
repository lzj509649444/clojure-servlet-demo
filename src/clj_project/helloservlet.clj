(ns clj-project.helloservlet
  (:gen-class :extends javax.servlet.http.HttpServlet
              :main false)
  (:import javax.servlet.http.HttpServletResponse))

(defn -doGet [_ _ response]
  (let [out (.getWriter response)]
    (.println out "Hello, world!"))
  (doto response
    (.setContentType "text/plain")
    (.setStatus HttpServletResponse/SC_OK)))
