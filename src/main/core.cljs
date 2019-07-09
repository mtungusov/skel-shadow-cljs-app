(ns core
  (:require [goog.dom :as gdom]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [events]
            [routes]
            [views :refer [app-root]]))


(defn- dev-setup []
  (when goog.DEBUG
    (enable-console-print!)
    (println "dev mode")))


(defn- app-element [id]
  (gdom/getElement id))


(defn- mount [el component]
  (r/render-component component el))


(defn- mount-app [id component]
  (when-let [el (app-element id)]
    (mount el component)))


(defn ^:after-load on-reload []
  (rf/clear-subscription-cache!)
  (mount-app "app" [app-root]))


(defn ^:export init []
  (dev-setup)
  (routes/app-routes)
  (rf/dispatch-sync [:initialize-db])
  (mount-app "app" [app-root]))
