all: compile test2 clean #doc

compile:
	@echo "#-----------------------"
	@echo "Compiling . . ."
	@echo "#-----------------------"
	@echo ""
	javac forms/*.java processingdata/*.java #-Xdiags:verbose
	@echo "\n"

clean:
	rm -f forms/*.class processingdata/*.class
	rm -r -f ../doc

test1:
	@echo "#-----------------------"
	@echo "Executing Test 1 . . ."
	@echo "#-----------------------"
	@echo ""
	@java forms.FormMain 
	@echo "\n"

test2:
	@echo "#-----------------------"
	@echo "Executing Test 2 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr4.tests.MainEx2 
	@echo "\n"

test3:
	@echo "#-----------------------"
	@echo "Executing Test 3 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr4.tests.MainEx3 
	@echo "\n"

doc:
	@echo "#-----------------------"
	@echo "Generating doc . . ."
	@echo "#-----------------------"
	@echo ""
	javadoc -d ../doc 
	@echo "\n"