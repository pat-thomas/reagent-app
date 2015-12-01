(defproject {{name}}
  :description "{{name}} (Reagent app)"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [;; server-side
                 [org.clojure/clojure "1.7.0"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [http-kit "2.1.18"]

                 ;; client-side
                 [org.clojure/clojurescript "1.7.170"]
                 [reagent "0.5.1"]]
  :cljsbuild {:builds [{:source-paths ["src/{{sanitized}}/app"]
                        :compiler     {:output-to     "public/js/{{sanitized}}.js"
                                       :optimizations :whitespace
                                       :pretty-print  true}}]})
