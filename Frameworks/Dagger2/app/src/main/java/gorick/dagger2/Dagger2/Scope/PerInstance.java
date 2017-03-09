package gorick.dagger2.Dagger2.Scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by sg-0036936 on 02/03/2017.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface PerInstance {}
