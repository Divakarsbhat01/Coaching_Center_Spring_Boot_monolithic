pipeline {
    environment 
    {     
        DOCKERHUB_CREDENTIALS=credentials('dockerhubcredentials')     
    }
    agent any
    tools {
        
        maven "maven3"
        }
    stages 
    {
        stage('Git Checkout') 
            {
                steps
                {
                    checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Divakarsbhat01/Coaching_Center_Spring_Boot_monolithic']])
                }
            }
        stage("Clean and Package")
            {
                steps
                {
                    sh "mvn clean package -DskipTests=true -Dspring.profiles.active=dev"
                }
            }
        stage("Dockerise Application")
            {
                steps
                {
                    sh "docker build -t  divakarsbhat1/coacen_sb_mono ."
                }
            }
        stage('Login to Docker Hub') 
            {      	
                steps
                {                       	
                	 withCredentials([usernamePassword(credentialsId: 'dockerhubcredentials', passwordVariable: 'dockerhub_password', usernameVariable: 'dockerhub_username')]) 
                	 {
                	     sh "docker login -u ${dockerhub_username} -p ${dockerhub_password}"
                    }     
                }           
            }
        stage('Push to Docker Hub') 
            {      	
                steps
                {                       	
                	     sh "docker push divakarsbhat1/coacen_sb_mono:latest"
                }           
            }
    }
        post
        {
            always 
                {  
            	    sh 'docker logout'     
                }      
        }
}
