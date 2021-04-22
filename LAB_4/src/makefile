all: compile test1 clean #doc

compile:
	@echo "#-----------------------"
	@echo "Compiling . . ."
	@echo "#-----------------------"
	@echo ""
	javac pr4/vehicles/*.java pr4/exceptions/*.java pr4/races/*.java pr4/tests/*.java pr4/components/*.java
	@echo "\n"

clean:
	rm -f pr4/exceptions/*.class
	rm -f pr4/components/*.class
	rm -f pr4/races/*.class
	rm -f pr4/vehicles/*.class
	rm -f pr4/tests/*.class
	rm -r -f doc

test1:
	@echo "#-----------------------"
	@echo "Executing Test 1 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr4.tests.MainEx1 ../txt/race.txt
	@echo "\n"

test1:
	@echo "#-----------------------"
	@echo "Executing Test 2 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr4.tests.MainEx2 ../txt/race.txt
	@echo "\n"

test3:
	@echo "#-----------------------"
	@echo "Executing Test 3 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr4.tests.
	@echo "\n"

test4:
	@echo "#-----------------------"
	@echo "Executing Test 4 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr4.tests.
	@echo "\n"

test5:
	@echo "#-----------------------"
	@echo "Executing Test 5 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr4.tests.
	@echo "\n"

exe1:
	@echo "#-----------------------"
	@echo "Executing Example1 of previous assignment . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr3.traffic.tests.Example1
	@echo "\n"

exe2:
	@echo "#-----------------------"
	@echo "Executing Example2 of previous assignment . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr3.traffic.tests.Example2
	@echo "\n"

doc:
	@echo "#-----------------------"
	@echo "Generating doc . . ."
	@echo "#-----------------------"
	@echo ""
	javadoc -d ../doc -author pr4/exceptions/*.java pr4/races/*.java pr4/vehicles/*.java
	@echo "\n"