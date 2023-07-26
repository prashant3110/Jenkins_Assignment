pipeline{
  agent any
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
  
