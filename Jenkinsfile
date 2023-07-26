pipeline{
  agent any
    tools{
      maven 'mvn_home'
    }
  
  stages{
    
    stage("build")
    {  
    steps{
        bat "mvn clean"
        }
    }

    stage("test")
    {
     steps{
        bat "mvn test"
        }
    }

  }

  post{
    sucess{
      bat "echo success"
    }
    
}
}
  
