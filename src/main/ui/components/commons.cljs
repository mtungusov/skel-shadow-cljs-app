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
  [:nav.navbar
   [:a.navbar-brand {:href (routes/href :routes/home)}
    [:span "Your Logo"]]
   [:div
    [:ul.navbar-nav
     [:li.nav-item [:a.nav-link {:href (routes/href :routes/home)} "Home"]]
     [:li.nav-item [:a.nav-link {:href (routes/href :routes/about)} "About"]]]]])
