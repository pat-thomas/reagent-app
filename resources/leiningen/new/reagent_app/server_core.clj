(ns {{name}}.server.core
    (:require [org.httpkit.server         :as http]
              [clojure.tools.nrepl.server :as nrepl]
              [compojure.core             :as compojure]
              [compojure.route            :as route]
              [cheshire.core              :as json]
              [{{name}}.api.command :as command]
              [{{name}}.api.query   :as query]
              [{{name}}.api.updates :as updates]))

(defn start-nrepl-server
  [port]
  (nrepl/start-server :port port)
  (println (format "nrepl server started on port %s" port)))

(compojure/defroutes app
  (compojure/GET "/ping"    request (json/generate-string {:status "OK" :message "PONG!"}))
  (compojure/GET "/query"   request (fn [request] (json/generate-string (query/handler request))))
  (compojure/PUT "/command" request (fn [request] (json/generate-string (command/handler request))))
  (compojure/GET "/updates" request (fn [request] (json/generate-string (updates/handler request)))))

(defn start-web-server
  [app port]
  (http/run-server #'app {:port port})
  (println (format "web server started on port %s" port)))

(defn main
  []
  (let [server-port 4015
        nrepl-port  5015]
    (start-nrepl-server nrepl-port)
    (start-web-server #'app server-port)))
