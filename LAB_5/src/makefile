all: compile test1 test2 test3 clean doc

compile:
	@echo "#-----------------------"
	@echo "Compiling . . ."
	@echo "#-----------------------"
	@echo ""
	javac forms/*.java processingdata/*.java protection/*.java #-Xdiags:verbose
	@echo "\n"

clean:
	rm -f forms/*.class processingdata/*.class protection/*.class
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
	@java processingdata.ProcessingMain 
	@echo "\n"

test3:
	@echo "#-----------------------"
	@echo "Executing Test 3 . . ."
	@echo "#-----------------------"
	@echo ""
	@java protection.ProtectedFormMain
	@echo "\n"

doc:
	@echo "#-----------------------"
	@echo "Generating doc . . ."
	@echo "#-----------------------"
	@echo ""
	javadoc -d ../doc -author forms/*.java processingdata/*.java protection/*.java
	@echo "\n"