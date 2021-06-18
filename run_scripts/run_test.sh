#############################################################################
#                       PREPARE PROJECT PARAMETERS                          #
#############################################################################

 

# Nom du répertoire du projet
TEST_PROJECT_NAME=datachallenge-test-auto


export TEST_APIKEY="8af2e205-6a35-4819-8fb2-452c8f3c5604"

#############################################################################
#                        KATALON TESTSUITES EXECUTION                       #
#############################################################################

 #TestSuiteCollection = executionProfile géré directement depuis Katalon Studio. 
 #TestSuite = executionProfile géré depuis la commande ci-dessous


bash katalon-execute.sh -executionProfile="default" -browserType="Chrome" -retry=0 -testSuitePath="${TEST_SUITE_PATH}" -apiKey=${TEST_APIKEY} -g_userPoolId="${userPoolId}" -g_app_id="${clientId}" -g_base_url="${url}" -g_xApiKey="${apiKeyValue}"


#katalonc -runMode=${TEST_RUNMODE} -apiKey=${TEST_APIKEY} -projectPath=${TEST_PROJECT_PATH} -retry=${TEST_RETRY} ${TESTSUITETYPE}="${TESTSUITE_PATH}" -summaryReport -Djava.awt.headless=true -reportFolder=${REPORT_PROJECT_PATH} -executionProfile=${EXECUTION_PROFILE} -browserType="${BROWSER_TYPE}"

