job ('elemplo2-job-DSL') {
      description('Job DSL de ejemplo para el curso de Jenkins')
  scm {
    git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node ->
      node / gitConfigName('DanielOrihuela')
      node / gitConfigEmail('erickorihuela92@gmail.com')
     }
  }
  parameters {
     stringParam('nombre', defaultValue = 'Julian', description = 'Parametro de cadena para el Job Boolean')
     choiceParam('planeta', ['Mercurio', 'Venus', 'Tierra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'] )
     booleanParam('agente', false)
  }
  triggers{
      cron('H/7 * * * *')
  }
  steps {
      shell("bash jobscript.sh")
  }          
}
