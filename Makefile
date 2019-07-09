.PHONY: clean dev prod

clean:
	rm -rf public/js/*

dev: clean 
	shadow-cljs watch app

prod: clean
	clj -A:uberjar --target $(JAR)
