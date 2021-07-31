pipelineJob('pipelinejob_converted') {

  description('')

  displayName('pipelinejob_converted')

  keepDependencies(false)

  quietPeriod(0)

  checkoutRetryCount(0)

  disabled(false)

  concurrentBuild(false)

  configure { flowdefinition ->

    flowdefinition / 'actions' << 'org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobAction'(plugin:'pipeline-model-definition@1.9.0')

    flowdefinition / 'actions' << 'org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobPropertyTrackerAction'(plugin:'pipeline-model-definition@1.9.0') {

      'jobProperties'()

      'triggers'()

      'parameters'()

      'options'()

    }

    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps@2.93') {

      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git@4.8.1') {

        'configVersion'(2)

        'userRemoteConfigs' {

          'hudson.plugins.git.UserRemoteConfig' {

            'url'('https://github.com/hirajendra2999/rworld.git')

            'credentialsId'('github-git')

          }

        }

        'branches' {

          'hudson.plugins.git.BranchSpec' {

            'name'('*/master')

          }

        }

        'doGenerateSubmoduleConfigurations'(false)

        'submoduleCfg'(class:'empty-list')

        'extensions'()

      }

      'scriptPath'('pipelines/pipeline2.jdp')

      'lightweight'(true)

    }

  }

}