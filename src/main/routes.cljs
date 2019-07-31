(ns routes
  (:import goog.History)
  (:require [re-frame.core :refer [dispatch] :as rf]
            ; [secretary.core :as secretary :refer-macros [defroute]]
            [goog.events :as gevents]
            [goog.history.EventType :as EventType]
            [oops.core :refer [oget oset!]]))


(defn hook-browser-navigation! []
  (doto (History.)
    (gevents/listen
     EventType/NAVIGATE
     (fn [event]
       (let [token (oget event "token")]
        ;  (secretary/dispatch! token)
         )))
    (.setEnabled true)))


(rf/reg-event-db
 :routes/home
 (fn [db _]
   (assoc-in db [:ui :screen] :home)))


(rf/reg-event-db
 :routes/about
 (fn [db _]
   (assoc-in db [:ui :screen] :about)))


; (secretary/set-config! :prefix "#")
; (defroute home "/"  [] (dispatch [:routes/home]))
; (defroute about "/about" [] (dispatch [:routes/about]))
; (defroute "*" [] (oset! js/window "location" "./"))
; (hook-browser-navigation!)
