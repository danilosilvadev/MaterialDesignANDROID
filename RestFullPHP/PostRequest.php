<?php

//Login Function

function checkLogin() {
        $username = $_POST['username'];
        $password = $_POST['password'];
        $sql = "select * FROM users WHERE ID = '$username' and PASSWORD ='$password'";
        try {
            $db = getConnection();
            $stmt = $db->prepare($sql);
            $stmt->execute();
            $user = $stmt->fetch(PDO::FETCH_OBJ);
            $db = null;
            if($user!= null){
                $output = array(
                        'status'=>"1",
                        'login'=>"sucess",
                        'user_data' => $user,
                );
            }
            else{
                $output = array(
                        'status'=>"0",
                        'login'=>"fail",
                );
            }
        }
        catch(Exception $ex){
            $output = array(
                    'status'=>"2",
                    'login'=>"error",
            );

        }
// $object = (object) $output;
        echo json_encode($output);
        $db = null;
    }

    //SingUp function

    function addUser()
    {
        $username = $_POST['username'];
        $password = $_POST['password'];
        $email = $_POST['email'];
        $point = 0;
        $level = 1;

        $sql = "INSERT INTO users (ID,EMAIL,PASSWORD)";
        $sql .= " VALUES ('$username','$email', '$password');";
        try
        {
            $db = getConnection();
            $stmt = $db->prepare($sql);
            $stmt->execute();
            $db = null;

            $output = array(
                    'status'=>"1",
                    'login'=>"sucess",
            );
            echo json_encode($output);

        } catch(PDOException $e) {
            $output = array(
                    'status'=>"0",
                    'login'=>"fail",
            );
            echo json_encode($output);
        }
    }

    ?>
