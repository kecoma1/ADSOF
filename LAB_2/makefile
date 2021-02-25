all: compile exe1 exe2 clean doc

compile:
	@echo "#-----------------------"
	@echo "Compiling . . ."
	@echo ""
	javac prac2/traffic/*.java
	@echo "\n"

clean:
	rm -f prac2/traffic/*.class
	rm -r -f doc

exe1:
	@echo "#-----------------------"
	@echo "Executing Example1 . . ."
	@echo ""
	java prac2/traffic/Example1
	@echo "\n"

exe2:
	@echo "#-----------------------"
	@echo "Executing Example2 . . ."
	@echo ""
	java prac2/traffic/Example2
	@echo "\n"

doc:
	javadoc -d doc -author prac2/traffic/*.java