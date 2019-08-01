(ns views
  (:require [ui.components.commons :refer [header]]
            [routes :refer [router-component]]))


;;; Views ;;;
(defn app-root []
  [:div.container
   [header]
   [router-component]])
