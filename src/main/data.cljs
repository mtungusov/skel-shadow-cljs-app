(ns data
  (:require [ajax.core :refer [GET]]
            [config :refer [api-url]]))


(defn- uri [api-url & path]
  (clojure.string/join "/" (concat [api-url] path)))


(defn fetch-data [success-fn error-fn]
  (GET
    (uri api-url "q/data-path-1")
    {:keywords? true
     :response-format :json
     :timeout 10000
     :handler success-fn
     :error-handler error-fn}))
