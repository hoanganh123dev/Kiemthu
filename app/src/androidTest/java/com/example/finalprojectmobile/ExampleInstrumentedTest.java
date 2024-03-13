package com.example.finalprojectmobile;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.init;
import static androidx.test.espresso.intent.Intents.release;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import static org.junit.Assert.*;

import com.example.finalprojectmobile.activities.AuthActivity;
import com.example.finalprojectmobile.activities.InsertActivity;
import com.example.finalprojectmobile.activities.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityScenarioRule<AuthActivity> activityScenarioRule = new ActivityScenarioRule<>(AuthActivity.class);

    @Test
    public void testViewPager2Initialization() {
        // Launch the activity
        ActivityScenario<AuthActivity> scenario = activityScenarioRule.getScenario();

        // Check if ViewPager2 is initialized
        onView(withId(R.id.view_pager2)).check(matches(isDisplayed()));
    }
    @Test
    public void testTabLayoutInitialization() {
        // Launch the activity
        ActivityScenario<AuthActivity> scenario = activityScenarioRule.getScenario();

        // Check if TabLayout is initialized
        onView(withId(R.id.tab_layout)).check(matches(isDisplayed()));
    }

    @Test
    public void testTabTitles() {
        // Launch the activity
        ActivityScenario<AuthActivity> scenario = activityScenarioRule.getScenario();

        // Check if tab titles are correct
        onView(withText("Login")).check(matches(isDisplayed()));
        onView(withText("Register")).check(matches(isDisplayed()));
    }
    @Test
    public void emailIsEmpty() {
        onView(withId(R.id.tv_email)).perform(clearText());
        onView(withId(R.id.login_btn)).perform(click());

    }

    @Test
    public void testLoginWithEmailAndPassword() {
        // Launch the activity
        ActivityScenario<AuthActivity> scenario = activityScenarioRule.getScenario();

        // Giả lập dữ liệu đăng nhập
        String email = "hoanganhphan294@gmail.com";
        String password = "Hoanganh@123";

        // Nhập email và mật khẩu vào các trường EditText
        onView(withId(R.id.et_email)).perform(typeText(email), closeSoftKeyboard());
        onView(withId(R.id.et_password)).perform(typeText(password), closeSoftKeyboard());

        // Nhấp vào nút đăng nhập
        onView(withId(R.id.login_btn)).perform(click());

        // Kiểm tra xem có chuyển hướng đến MainActivity không
        intended(hasComponent(MainActivity.class.getName()));
    }

}