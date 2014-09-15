App Localization Demo
=====================
<p>&nbsp;</p>

<p><strong>1.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Register your app:</strong></p>

<p>Select <strong><em>Catalog -&gt; Applications and Categories </em></strong>page. You will see something similar as in the picture below:</p>

<p><img alt="" src="http://nativer01.nativer.com/prod/image/data/ImagesforDeveloperProcess/RegisterApp_Picture01_AppsAndCategSelected.jpg" style="height:371px; width:670px" /></p>

<p>&nbsp;</p>

<p>Press the <strong>Insert application </strong>button.<br />
Enter the package name of your application as seen below (in place of <em>eu.appround.highwayportal </em>please enter<br /> the package name your application has been uploaded to Google Play with)</p>

<p><img alt="" src="http://nativer01.nativer.com/prod/image/data/ImagesforDeveloperProcess/RegisterApp_Picture02_EnterPackageName.jpg" style="height:371px; width:670px" /></p>

<p>When ready, press the <strong>Download / reload application data from Google Play </strong>button</p>

<p>Now please be patient for a while. The Nativer server will find your application on Google Play,<br />
will download from there all the public data, and will populate all the relevant fields (name, merketing text, icon, etc.).<br />
This may take a few seconds, sometimes even a minute.<br />
When finished, you will see the result similar to the picture below.</p>

<p><img alt="" src="http://nativer01.nativer.com/prod/image/data/ImagesforDeveloperProcess/RegisterApp_Picture03_AppDataDownloadedFromGP.jpg" style="height:371px; width:670px" /></p>

<p>&nbsp;</p>

<p>After the fileds were populated, press the <strong>Save </strong>button. The screen will show something similar to the picture below.<br />
The status of you application will be &quot;<em>Unconfirmed</em>&quot;, similar to the application on the picture.</p>

<p><img alt="" src="http://nativer01.nativer.com/prod/image/data/ImagesforDeveloperProcess/RegisterApp_Picture04_AfterSaveAppWaitingForConfirmation.jpg" style="height:371px; width:670px" /></p>

<p>&nbsp;</p>

<p><strong>2.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Registration confirmation</strong>:</p>

<p>Nativer sends registration link to the app market contact (this does not need to be the same contact for Nativer).<br />
So it is time to check the mailbox. You should receive in short time an email from our system<br />
wich has the aim to help us confirm that you are really the owner/developer of the freshly registered application.<br />
If you do not receive our email within few hours, please also check the spam folder for it.<br />
The email will be something very similar to this:</p>

<p><img alt="" src="http://nativer01.nativer.com/prod/image/data/ImagesforDeveloperProcess/RegisterApp_Picture05_AppOwnershipConfirmationLetter.jpg" style="height:248px; width:447px" /></p>

<p>&nbsp;</p>

<p>By clicking the confirmation link in the email the application gets registered to you<br />
under <em>Catalog -&gt; Applications and Categories </em>the application status changes to &ldquo;<em>In preparation (confirmed)</em>&rdquo;.<br />
If you check your application&#39;s status, it will look like in the picture below:</p>

<p><img alt="" src="http://nativer01.nativer.com/prod/image/data/ImagesforDeveloperProcess/RegisterApp_Picture07_AppOwnershipConfirmedInAppsAndCategories.jpg" style="height:371px; width:670px" /></p>

<p>&nbsp;</p>

<h1>Nativer SDK technical background</h1>

<h1>1.&nbsp;&nbsp; Glossary:</h1>

<p>Host Application: Is the original Application of a developer. By adding the Nativer SDK to it, becomes NLE Application</p>

<p>NLE Application: Stands for Nativer Localization Enabled Application. This is an original Application of a developer, in which the Nativer SDK has been embedded.</p>

<p>Nativer SDK: A set of functions and libraries, which enable the host Application to become easily translatable in the Nativer Ecosystem</p>

<p>Nativer Application: This is Transround&rsquo;s own application, called Nativer, which implements majority of the functionality of the Nativer Ecosystem, like requesting localizations, downloading ready localizations, translate, proof reading, support, etc.</p>

<p>&nbsp;</p>

<h1>2.&nbsp;&nbsp; Nativer SDK</h1>

<h2>2.1&nbsp;&nbsp;&nbsp;&nbsp; Nativer SDK - generalities</h2>

<p>Majority of developers use at least one 3rd party SDK (Google Analytics, Advertisment ,etc.) in their applications. As this is a widely used practice, using of the Nativer SDK should not be a problem. If you have no experience with using SDK, please follow thoroughly our tutorial.</p>

<p>&nbsp;</p>

<h2>2.2&nbsp;&nbsp;&nbsp;&nbsp; Nativer SDK - technology</h2>

<p>Nativer SDK uses Aspect Oriented Programming (AOP) technique. Aspect-Oriented Programming is a software development technology that seeks new modularizations of software systems in order to isolate secondary or supporting functions from the main program&#39;s business logic.</p>

<p>This is why decision of using this technology has been taken: in order to securely combine the original Application and Nativer SDK features at runtime level, and to provide views that segregate them properly, to maintain the original Application&#39;s own full functionality and behavior.</p>

<p>This technology is widely used in similar cases not only by individual programmers in their own applications, but also by big names, like IBM, Sun/Oracle, Google, etc., it represents the actual best practice for such solutions.</p>

<p>If you wish to know more about AOP please find below a few links, where you can find a deeper insight:</p>

<p><a href="http://www.ibm.com/developerworks/views/java/libraryview.jsp?search_by=AOP@work">http://www.ibm.com/developerworks/views/java/libraryview.jsp?search_by=AOP@work</a>:</p>

<p><a href="http://www.javaworld.com/javaworld/jw-01-2002/jw-0118-aspect.html">http://www.javaworld.com/javaworld/jw-01-2002/jw-0118-aspect.html</a></p>

<p><a href="http://codefez.com/what-is-aspect-oriented-programming/">http://codefez.com/what-is-aspect-oriented-programming/</a></p>

<p><a href="http://www.devx.com/Java/Article/28422">http://www.devx.com/Java/Article/28422</a></p>

<p><a href="http://www.eclipse.org/aspectj/doc/released/progguide/index.html">http://www.eclipse.org/aspectj/doc/released/progguide/index.html</a></p>

<p>&nbsp;</p>

<p>A few examples of Android AspectJ on Google.com:</p>

<p><a href="http://code.google.com/p/android-aspectj/">http://code.google.com/p/android-aspectj/</a></p>

<p><a href="http://code.google.com/p/android-aspectj/wiki/IntegrationwithMaven">http://code.google.com/p/android-aspectj/wiki/IntegrationwithMaven</a></p>

<p><a href="http://code.google.com/p/android-aspectj/source/checkout">http://code.google.com/p/android-aspectj/source/checkout</a></p>

<p>&nbsp;</p>

<p>The Nativer SDK carefully treats the followings:</p>

<ul>
	<li>Speed of the solution:</li>
</ul>

<p>The AOP technique carefully used ensures that the speed of the original Application is not altered. Several solutions and hints for avoiding speed issues are available on <a href="http://www.stackoverflow.com/">www.stackoverflow.com</a></p>

<ul>
	<li>Memory consumption:</li>
</ul>

<p>AOP in general does not causes extreme increase of memory consumption. A few hints to ensure this may be found on <a href="http://andrewclement.blogspot.com/">http://andrewclement.blogspot.com/</a></p>

<ul>
	<li>Security:</li>
</ul>

<p>AOP is often used when there is a need for troubleshooting problems in third-party libraries without source codes or in an environment where it isn&rsquo;t possible to use a debugger or a profiler. It also enables to modify third party, closed-source classes and actually even JVM classes. This might be important when working with legacy code and code for which the source codes are not available, and the limitations or bugs of these 3rd-party binaries are inevitably occasionally hit. Therefore many programmers use this method, a large number of applications already use it. By following the design and coding best practices in the Nativer SDK, the security of the host Application and also the security of the whole solution do not represent additional threat. See more details for example here: <a href="http://www.javacodegeeks.com/2011/09/practical-introduction-into-code.html">http://www.javacodegeeks.com/2011/09/practical-introduction-into-code.html</a></p>

<p>&nbsp;</p>

<p><strong><em>Advantages of using the Nativer SDK</em></strong></p>

<ul>
	<li>Does not need deep ApsectJ or other kind of AOP knowledge. Just follow the provided installation procedure of the Nativer SDK</li>
	<li>According to the measurements made with several apps, the overall speed of the Applications using Nativer SDK did not change significantly.</li>
	<li>Nativer takes care to have all necessary components embedded. you do not need to care about.</li>
	<li>Carefully designed and coded for minimal memory consumption, tested for memory leaks.</li>
</ul>

<p>&nbsp;</p>

<h1>3.&nbsp; Connection to other Applications</h1>

<p>During its function, Nativer SDK occasionally (upon functionality need) may call some functions or libraries of the Nativer Application, which is also installed on the user&rsquo;s device. The reason for this is to keep the Nativer SDK as light as possible, and ensure in the meantime that all necessary runtime libraries are available in the right version. Therefore several functions, which might be needed to be available both in the NLE Application and the Nativator Application are implemented in one single place only: the Nativer Application, and called by the NLE App when needed.</p>

<p>Characteristics of the solution.</p>

<ul>
	<li>Nativer SDK embedded into NLE Applications uses functions and libraries of Nativer Application only.</li>
	<li>For this we use only Google standard tools.</li>
	<li>The solution is fully documented</li>
</ul>

<p>&nbsp;</p>

<h1>4.&nbsp; Dynamic resource handling</h1>

<p>Translations (localizations) are stored by the Nativer SDK as dynamic resources. This is how different localizations which are originally not part of the host Application will become available and usable by the NLE Application. The Nativer SDK simply dynamically (i.e. runtime) &ldquo;reads&rdquo; from its own database the necessary strings or phrases and replaces on the screen of the Application the original language texts with the translated ones.</p>

<p>Characteristics of Nativer SDK&rsquo;s dynamic resource handling:</p>

<ul>
	<li>The resources loaded by Nativer SDK into the hosting Application are pure strings, replacing the original strings of the Application</li>
	<li>The replacement strings are stored in a SQLLite3 database</li>
	<li>If somebody maliciously alters the content of the database, functions of the hosting application may not be changed, the only undesirable result is, that the hosting Application&rsquo;s phrases&rsquo; meaning may differ from the original.</li>
	<li>Nativer Application makes possible the correction by re-downloading the correct ones.</li>
</ul>

<p>&nbsp;</p>

<p><a href="http://nativer01.nativer.com/prod/admin/index.php?route=common/information&amp;token=[__token__]&amp;information_id=13&amp;menu=devres">Next</a></p>

<p>&nbsp;</p>



