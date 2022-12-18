/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import model.User;

import java.util.List;
/**
 *
 * @author Alany Souza 2021345 and Thaynna Vieira 2021288
 */

public interface UserDataProviderInterface {
    public List<User> listAll();
    public User findByUsername(String username);
    public int updateFirstName(int userId, String firstName);
    public int updateLastName(int userId, String firstName);
}
