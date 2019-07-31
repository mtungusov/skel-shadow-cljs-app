(ns views
  (:require [re-frame.core :refer [subscribe]]
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
 :templ/page
 (fn [db _]
   (:page db)))

; Views
(defn app-root []
  (let [msg (subscribe [::templ/msg])
        page (subscribe [:templ/page])]
      [:div.container
       [header]
       [s-home/core msg page]]))
