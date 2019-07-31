.PHONY: clean dev prod

clean:
	rm -rf public/js/*

dev: clean 
	shadow-cljs -A:dev watch app

prod: clean
	shadow-cljs -A:prod release app
