(ns example.impl)

;; all Clojure fns are callable
(defn create-hello-fn [] (fn [] "hello"))

;; implement Java interface with reify
(defn create-never-filter
  []
  (reify java.io.FileFilter (accept [_ _] false)))

;; extend Java classes with proxy
(defn create-timestamped-object
  []
  (let [s (format "<object created %s>" (str (java.util.Date.)))]
    (proxy [java.lang.Object] [] (toString [] s))))
