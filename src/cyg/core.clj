(ns cyg.core
  (:require
    [clojure.tools.reader.edn :as edn]
    [clojure.java.io :refer [resource]]))

(def config-resource (or (resource "config.edn") (resource "config.clj")))

(def config
  (try
    (edn/read-string (slurp config-resource))
    (catch Exception e
      (println "Unable to parse config: " e))))

(defn cf [& ks] (get-in config ks nil))
