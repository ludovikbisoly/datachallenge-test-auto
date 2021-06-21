#!/bin/bash

#############################################################################
#                       PREPARE PROJECT PARAMETERS                          #
#############################################################################

TEST_PROJECT_NAME=datachallenge-test-auto

HOME_DIRECTORY=~/workspace
#source ${HOME_DIRECTORY}/${TEST_PROJECT_NAME}/ci_config/project_settings.ini
export TEST_APIKEY="8af2e205-6a35-4819-8fb2-452c8f3c5604"

#############################################################################
#                        KATALON TESTSUITES EXECUTION                       #
#############################################################################

 #TestSuiteCollection = executionProfile géré directement depuis Katalon Studio. 
 #TestSuite = executionProfile géré depuis la commande ci-dessous
echo "----------------"
echo "test echo executionProfile"
echo "${executionProfile}"
echo "----------------"
bash katalon-execute.sh -executionProfile="default" -browserType="Chrome" -retry=0 -testSuitePath="Test Suites/API/datachallenge-backend" -apiKey=${TEST_APIKEY}
#-g_x_api_key=${apiKeyValue} -g_user_pool_id=${userPoolId} -g_app_id=${clientId} -g_admin_password=${pwd_admin} -g_admin_username=${username_admin}
