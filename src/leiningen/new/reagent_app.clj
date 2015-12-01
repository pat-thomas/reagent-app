(ns leiningen.new.reagent-app
  (:require [leiningen.new.templates :as templates]
            [leiningen.core.main     :as main]))

(def render (templates/renderer "reagent-app"))

(defn reagent-app
  "Basic template for a single page ClojureScript app (Reagent)."
  [name]
  (let [data {:name name
              :sanitized (templates/name-to-path name)}
        render-from-data (fn [filepath]
                           (render filepath data))]
    (main/info "Generating fresh 'lein new' reagent-app project.")
    (templates/->files data
                       ["project.clj"                       (render-from-data "project.clj")]
                       ["src/{{sanitized}}/server/core.clj" (render-from-data "server_core.clj")]
                       ["src/{{sanitized}}/app/core.cljs"   (render-from-data "app_core.cljs")])))
