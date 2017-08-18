(require '[cljs.build.api :as b])

(println "Building ...")

(let [start (System/nanoTime)]
  (b/build "src"
           {:output-dir "release"
	    :install-deps true
	    :npm-deps {:bootstrap "4.0.0-beta"}
            :modules {:moduleb {:output-to "release/moduleb.js"
                                :entries #{'moduleb}} }
            :optimizations :advanced
            :verbose true
            :pretty-print false})
  (println "... done. Elapsed" (/ (- (System/nanoTime) start) 1e9) "seconds"))
