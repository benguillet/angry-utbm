SOURCE=rapport
LATEX=xelatex -shell-escape


comp:
	$(LATEX)  $(SOURCE).tex
	evince $(SOURCE).pdf &

clean:
	rm -f *.aux *.out *.log 
	rm -f *.snm *.toc *.nav
	rm -f *.pyg

