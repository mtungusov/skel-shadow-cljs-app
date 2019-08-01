(ns core
  (:require [goog.dom :as gdom]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [app-db :refer [default-db]]
            [routes :refer [init-routes!]]
            [views :refer [app-root]]))


(defn- dev-setup []
  (when goog.DEBUG
    (enable-console-print!)
    (println "dev mode")))


(defn- mount-app [id component]
  (when-let [el (gdom/getElement id)]
    (r/render-component component el)))


(rf/reg-event-fx
 :initialize
 (fn  [_ _]
   {:db default-db}))


(defn ^:after-load on-reload! []
  (rf/clear-subscription-cache!)
  (init-routes!)
  (mount-app "app" [app-root]))


(defn ^:export init! []
  (dev-setup)
  (rf/dispatch-sync [:initialize])
  (init-routes!)
  (mount-app "app" [app-root]))
