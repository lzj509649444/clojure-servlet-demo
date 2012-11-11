(ns clj-project.core
  (:import org.eclipse.jetty.server.Server
           org.eclipse.jetty.servlet.ServletHolder
           org.eclipse.jetty.servlet.ServletContextHandler)
  (:require [clj-project.helloproxy :as hello-servlet]))

(defn- hello-servlet-holder []
  (doto (ServletHolder.)
    (.setServlet (hello-servlet/servlet))))

(defn- create-server []
  (let [context (doto (ServletContextHandler. ServletContextHandler/SESSIONS)
                  (.setContextPath "/"))
        server (doto (Server. 8080)
                      (.setHandler context))]
    (.addServlet context (hello-servlet-holder) "/")
    (.start server)
    (.join server)))

(defn -main [& args]
  (println "hello world!")
  (create-server))
