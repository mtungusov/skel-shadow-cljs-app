.PHONY: clean dev prod

clean:
	rm -rf public/js/*

dev: clean 
	shadow-cljs watch app

prod: clean
	shadow-cljs release app
