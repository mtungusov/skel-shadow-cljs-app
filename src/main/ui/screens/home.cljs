(ns ui.screens.home
  (:require [ui.components.commons :refer [header]]))


(defn core [msg page]
  [:div
   [:p (str "Page: " page)]
   [:p (str "Msg: " msg)]])
