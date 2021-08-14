(ns cljls.core
  (:import [java.io File]))

(defn list-file-name
  [path]
  (->> (.listFiles (File. ^String path))
       (filter #(not (.isHidden %)))
       (sort-by #(.toString %))
       (map #(.getName %))))
