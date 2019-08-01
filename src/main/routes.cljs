(ns routes
  (:require [re-frame.core :as re-frame]
            [reitit.core :as r]
            [reitit.frontend :as rf]
            [reitit.frontend.controllers :as rfc]
            [reitit.frontend.easy :as rfe]
            
            [ui.screens.home :as s-home]
            [ui.screens.about :as s-about]))


;;; Events ;;;
(re-frame/reg-event-fx
 ::navigate
 (fn [db [_ route]]
   {::navigate! route}))


(re-frame/reg-event-db
 ::navigated
 (fn [db [_ new-match]]
   (let [old-match   (:current-route db)
         controllers (rfc/apply-controllers (:controllers old-match) new-match)]
     (assoc db :current-route (assoc new-match :controllers controllers)))))


;;; Effects ;;;
(re-frame/reg-fx
 ::navigate!
 (fn [k params query]
   (rfe/push-state k params query)))


;;; Subscriptions ;;;
(re-frame/reg-sub
 ::current-route
 (fn [db]
   (:current-route db)))


;;; Routes ;;;
(def routes
  [["/"
    {:name ::home
     :screen s-home/core
     :controllers
     [{:start (fn [& params] (js/console.log "Entering home page"))
       :stop (fn [& params] (js/console.log "Leaving home page"))}]}]
   ["/about"
    {:name ::about
     :screen s-about/core
     :controllers
     [{:start (fn [& params] (js/console.log "Entering about page"))
       :stop (fn [& params] (js/console.log "Leaving about page"))}]}]])


(def router
  (rf/router routes))


(defn- on-navigate [new-match]
  (when new-match
    (re-frame/dispatch [::navigated new-match])))


(defn init-routes! []
  (js/console.log "initializing routes")
  (rfe/start!
   router
   on-navigate
   {:use-fragment true}))


(defn href
  "Return relative url for given route. Url can be used in HTML links."
  ([k]
   (href k nil nil))
  ([k params]
   (href k params nil))
  ([k params query]
   (rfe/href k params query)))


(defn router-component []
  (let [current-route @(re-frame/subscribe [::current-route])]
    [:div
     (when current-route
       [(-> current-route :data :screen)])]))
