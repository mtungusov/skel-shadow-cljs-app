(ns views
  (:require [re-frame.core :refer [subscribe] :as rf]
            [ui.components.commons :refer [header]]
            [ui.screens.home :as s-home]))

; Events
; Effects

; Subscriptions
(rf/reg-sub
 :templ/msg
 (fn [db _]
   (:msg db)))


(rf/reg-sub
 :templ/screen
 (fn [db _]
   (get-in db [:ui :screen])))

; Views
(defn app-root []
  (let [msg @(subscribe [:templ/msg])
        screen @(subscribe [:templ/screen])]
      [:div.container
       [header]
       (s-home/core msg screen)]))
