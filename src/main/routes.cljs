(ns routes
  (:import goog.History)
  (:require [re-frame.core :refer [dispatch]]
            [secretary.core :as secretary :refer-macros [defroute]]
            [goog.events :as gevents]
            [goog.history.EventType :as EventType]))


(defn hook-browser-navigation! []
  (doto (History.)
    (gevents/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn app-routes []
  (secretary/set-config! :prefix "#")
  (defroute home "/"  [] (dispatch [:routes/home]))
  (defroute about "/about" [] (dispatch [:routes/about]))
  (defroute "*" [] (aset js/window "location" "./"))
  (hook-browser-navigation!))
