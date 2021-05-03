all: compile test3 clean #doc

compile:
	@echo "#-----------------------"
	@echo "Compiling . . ."
	@echo "#-----------------------"
	@echo ""
	javac -Xdiags:verbose forms/*.java processingdata/*.java protected/*.java
	@echo "\n"

clean:
	rm -f forms/*.class processingdata/*.class protected/*.class
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
	@java protected.ProtectedFormMain
	@echo "\n"

doc:
	@echo "#-----------------------"
	@echo "Generating doc . . ."
	@echo "#-----------------------"
	@echo ""
	javadoc -d ../doc 
	@echo "\n"