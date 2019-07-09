(ns subs
  (:require [re-frame.core :as rf]))


(rf/reg-sub
 ::msg
 (fn [db _]
   (:msg db)))


(rf/reg-sub
 ::page
 (fn [db _]
   (:page db)))