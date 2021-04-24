all: compile test1 test2 test3 test4 clean doc

compile:
	@echo "#-----------------------"
	@echo "Compiling . . ."
	@echo "#-----------------------"
	@echo ""
	javac pr4/vehicles/*.java pr4/exceptions/*.java pr4/races/*.java pr4/tests/*.java pr4/components/*.java pr4/powerUps/*.java
	@echo "\n"

clean:
	rm -f pr4/exceptions/*.class
	rm -f pr4/powerUps/*.class
	rm -f pr4/components/*.class
	rm -f pr4/races/*.class
	rm -f pr4/vehicles/*.class
	rm -f pr4/tests/*.class
	rm -r -f ../doc

test1:
	@echo "#-----------------------"
	@echo "Executing Test 1 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr4.tests.MainEx1 ../txt/race.txt
	@echo "\n"

test2:
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
	@java pr4.tests.MainEx3 ../txt/race.txt
	@echo "\n"

test4:
	@echo "#-----------------------"
	@echo "Executing Test 4 . . ."
	@echo "#-----------------------"
	@echo ""
	@java pr4.tests.MainEx4 ../txt/race.txt
	@echo "\n"

doc:
	@echo "#-----------------------"
	@echo "Generating doc . . ."
	@echo "#-----------------------"
	@echo ""
	javadoc -d ../doc -author pr4/vehicles/*.java pr4/exceptions/*.java pr4/races/*.java pr4/tests/*.java pr4/components/*.java pr4/powerUps/*.java
	@echo "\n"