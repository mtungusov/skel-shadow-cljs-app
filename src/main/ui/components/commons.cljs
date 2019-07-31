(ns ui.components.commons
  (:require [re-frame.core :refer [subscribe dispatch] :as rf]
            [routes]
            [ui.screens.auth :refer [g-sign-out-button]]))

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
    [:img.header__logo.img-fluid {:src "img/common/logo.svg"}]]])
