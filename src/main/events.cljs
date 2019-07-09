(ns events
  (:require [re-frame.core :as rf]
            [app-db :refer [default-db]]))


(rf/reg-event-db
 :initialize-db
 (fn  [_ _]
    default-db))

(rf/reg-event-db
 :routes/home
 (fn [db _]
   (assoc db :page :home)))

(rf/reg-event-db
 :routes/about
 (fn [db _]
   (assoc db :page :about)))
