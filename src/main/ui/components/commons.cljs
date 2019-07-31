(ns ui.components.commons
  (:require [re-frame.core :refer [subscribe dispatch] :as rf]
            [routes]))

; Subscriptions
(rf/reg-sub
 :ui
 (fn [db _]
   (:ui db)))

(rf/reg-sub
 :ui/screen
 :<- [:ui]
 (fn [ui]
   (:screen ui)))

; Views
(defn header []
  [:nav.navbar.navbar-light.header__search-wraper
   [:a.navbar-brand {:href (routes/home)}
    [:span "Your Logo"]]])
