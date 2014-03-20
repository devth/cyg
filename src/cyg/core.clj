(ns cyg.core
  (:require
    [clojure.tools.reader.edn :as edn]
    [clojure.java.io :refer [resource]]))

(def ^:private autoreload (atom false))

(def ^:private config-resource (or (resource "config.edn") (resource "config.clj")))

(def ^:private config (atom {}))

; public

(defn reload-config []
  (reset! config (try
                   (edn/read-string (slurp config-resource))
                   (catch Exception e
                     (println "Unable to parse config: " e)))))

(reload-config)

(defn autoreload!
  ([should-autoreload] (reset! autoreload should-autoreload))
  ([] (autoreload! true)))

(defn cf [& ks]
  (when @autoreload (reload-config))
  (get-in @config ks nil))
