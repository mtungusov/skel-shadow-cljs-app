(ns views
  (:require [re-frame.core :refer [subscribe]]
            [subs]))


(defn app-root []
  (let [msg (subscribe [::subs/msg])
        page (subscribe [::subs/page])]
      [:div
       [:h3 "Demo re-frame"]
       [:p @msg]
       [:p (str "Current page: " @page)]
       [:div
        [:a {:href "/"} "Home"]
        [:a {:href "#/"} "#Home"]
        [:br]
        [:a {:href "/about"} "About"]
        [:a {:href "#/about"} "#About"]
        [:br]
        [:a {:href "#/about-not-found"} "#About Not found"]]]))
