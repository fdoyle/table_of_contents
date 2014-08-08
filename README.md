Currently this is just a demo project

hopefully it'll turn into something more

todo: 
add a proper .gitignore
{
add concept of an ActivityFactory - an object that contains methods which return intents to open a particular activity. 
this would allow users to set up different ways to open the activity, like adding intent extras, intent flags, things like that. 

Ideally, this should follow our internal pattern of static getIntent methods. 

Map activity Class object to its builder, parse out methods with @IntentBuilder, display in list. user can pick from list to use the intents created by those methods. 
}
