<map version="freeplane 1.7.0">
<!--To view this file, download free mind mapping software Freeplane from http://freeplane.sourceforge.net -->
<node TEXT="Hibernate" FOLDED="false" ID="ID_1073335346" CREATED="1573054148953" MODIFIED="1573054195122" STYLE="oval">
<font SIZE="18"/>
<hook NAME="MapStyle" zoom="1.5">
    <properties fit_to_viewport="false" edgeColorConfiguration="#808080ff,#ff0000ff,#0000ffff,#00ff00ff,#ff00ffff,#00ffffff,#7c0000ff,#00007cff,#007c00ff,#7c007cff,#007c7cff,#7c7c00ff"/>

<map_styles>
<stylenode LOCALIZED_TEXT="styles.root_node" STYLE="oval" UNIFORM_SHAPE="true" VGAP_QUANTITY="24.0 pt">
<font SIZE="24"/>
<stylenode LOCALIZED_TEXT="styles.predefined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="default" ICON_SIZE="12.0 pt" COLOR="#000000" STYLE="fork">
<font NAME="SansSerif" SIZE="10" BOLD="false" ITALIC="false"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.details"/>
<stylenode LOCALIZED_TEXT="defaultstyle.attributes">
<font SIZE="9"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.note" COLOR="#000000" BACKGROUND_COLOR="#ffffff" TEXT_ALIGN="LEFT"/>
<stylenode LOCALIZED_TEXT="defaultstyle.floating">
<edge STYLE="hide_edge"/>
<cloud COLOR="#f0f0f0" SHAPE="ROUND_RECT"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.user-defined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="styles.topic" COLOR="#18898b" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subtopic" COLOR="#cc3300" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subsubtopic" COLOR="#669900">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.important">
<icon BUILTIN="yes"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.AutomaticLayout" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="AutomaticLayout.level.root" COLOR="#000000" STYLE="oval" SHAPE_HORIZONTAL_MARGIN="10.0 pt" SHAPE_VERTICAL_MARGIN="10.0 pt">
<font SIZE="18"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,1" COLOR="#0033ff">
<font SIZE="16"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,2" COLOR="#00b439">
<font SIZE="14"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,3" COLOR="#990000">
<font SIZE="12"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,4" COLOR="#111111">
<font SIZE="10"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,5"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,6"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,7"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,8"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,9"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,10"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,11"/>
</stylenode>
</stylenode>
</map_styles>
</hook>
<hook NAME="AutomaticEdgeColor" COUNTER="10" RULE="ON_BRANCH_CREATION"/>
<node TEXT="POJO/POCO" FOLDED="true" POSITION="right" ID="ID_1545180458" CREATED="1573054179362" MODIFIED="1573054276902">
<edge COLOR="#ff0000"/>
<node TEXT="Constructor vac&#xed;o" ID="ID_1082006681" CREATED="1573054195861" MODIFIED="1573054259939">
<font BOLD="true"/>
</node>
<node TEXT="Identificador" FOLDED="true" ID="ID_1799345453" CREATED="1573054227250" MODIFIED="1573054264243">
<font BOLD="true"/>
<node TEXT="Normalmente es la clave primaria" ID="ID_982515718" CREATED="1573054244689" MODIFIED="1573054249576"/>
</node>
<node TEXT="Propiedades" FOLDED="true" ID="ID_84131490" CREATED="1573054292706" MODIFIED="1573054305005">
<node TEXT="getters y setters" ID="ID_1000728361" CREATED="1573054305370" MODIFIED="1573054308530"/>
</node>
</node>
<node TEXT="Estados" FOLDED="true" POSITION="right" ID="ID_65594376" CREATED="1573054327874" MODIFIED="1573054329987">
<edge COLOR="#0000ff"/>
<node TEXT="Transient" FOLDED="true" ID="ID_500651057" CREATED="1573054349545" MODIFIED="1573054351474">
<node TEXT="No ha tenido ninguna relaci&#xf3;n con Hibernate" ID="ID_202809872" CREATED="1573054366933" MODIFIED="1573054375508"/>
<node TEXT="new" ID="ID_613460944" CREATED="1573054383546" MODIFIED="1573054386808"/>
<node TEXT="No tiene identificador" ID="ID_520623390" CREATED="1573054430907" MODIFIED="1573054921732">
<font BOLD="true"/>
</node>
<node TEXT="No hay fila en la base de datos para el objeto" ID="ID_1359223710" CREATED="1573054443801" MODIFIED="1573054450776"/>
<node TEXT="Los cambios del objeto, no se reflejan en la base de datos" ID="ID_638968124" CREATED="1573054458132" MODIFIED="1573054466702"/>
</node>
<node TEXT="Persistent" FOLDED="true" ID="ID_1200116186" CREATED="1573054352319" MODIFIED="1573054355508">
<node TEXT="Asociado a un contexto de persistencia (sesi&#xf3;n)" ID="ID_644238459" CREATED="1573054488506" MODIFIED="1573054498854"/>
<node TEXT="Tiene un identificador" FOLDED="true" ID="ID_294806974" CREATED="1573054506483" MODIFIED="1573054519783">
<node TEXT="Normalmente en una fila de la base de datos" ID="ID_1273486818" CREATED="1573054520058" MODIFIED="1573054526010"/>
</node>
<node TEXT="Los cambios se reflejan en la base de datos (al hacer commit)" ID="ID_1488041940" CREATED="1573054540449" MODIFIED="1573054553466"/>
<node TEXT="Transient -&gt; save(objeto) -&gt; Persistent" ID="ID_397996077" CREATED="1573054593735" MODIFIED="1573054999840">
<font BOLD="true"/>
</node>
</node>
<node TEXT="Detached" FOLDED="true" ID="ID_1298955550" CREATED="1573054355732" MODIFIED="1573054358767">
<node TEXT="Fue persistent" ID="ID_1058034463" CREATED="1573054732106" MODIFIED="1573054736634"/>
<node TEXT="Se perdi&#xf3; el contexto" ID="ID_906702850" CREATED="1573054742045" MODIFIED="1573054748558"/>
<node TEXT="Tiene identificador" ID="ID_1889496974" CREATED="1573054790775" MODIFIED="1573054920289">
<font BOLD="true"/>
</node>
<node TEXT="Los cambios no se guardan" ID="ID_1400981578" CREATED="1573054941508" MODIFIED="1573054947550"/>
<node TEXT="Detached -&gt; merge(objeto) -&gt; Persistent" ID="ID_863280800" CREATED="1573054968331" MODIFIED="1573055005626">
<font BOLD="true"/>
</node>
</node>
</node>
<node TEXT="M&#xe9;todos" FOLDED="true" POSITION="right" ID="ID_1432571621" CREATED="1573055083277" MODIFIED="1573055087034">
<edge COLOR="#00ff00"/>
<node TEXT="Transient -&gt; Persistent" FOLDED="true" ID="ID_1295229971" CREATED="1573055087611" MODIFIED="1573055095050">
<node TEXT="save()" ID="ID_927499193" CREATED="1573055095214" MODIFIED="1573055097655"/>
<node TEXT="persist()" FOLDED="true" ID="ID_335495040" CREATED="1573055097776" MODIFIED="1573055100821">
<node TEXT="JPA" ID="ID_1848632270" CREATED="1573055103008" MODIFIED="1573055103773"/>
</node>
<node TEXT="saveOrUpdate()" ID="ID_671275120" CREATED="1573055109015" MODIFIED="1573055112146"/>
</node>
<node TEXT="Persistent -&gt; Transient" FOLDED="true" ID="ID_1189435904" CREATED="1573055148988" MODIFIED="1573055157896">
<node TEXT="delete()" ID="ID_1718047328" CREATED="1573055168588" MODIFIED="1573055171290"/>
</node>
<node TEXT="Persistent" FOLDED="true" ID="ID_1636070681" CREATED="1573055311445" MODIFIED="1573055313253">
<node TEXT="get()" FOLDED="true" ID="ID_194994510" CREATED="1573055313586" MODIFIED="1573055318629">
<node TEXT="Devuelve null si no encuentra" ID="ID_163170904" CREATED="1573061321802" MODIFIED="1573061327318"/>
</node>
<node TEXT="load()" FOLDED="true" ID="ID_841153675" CREATED="1573055318767" MODIFIED="1573055320029">
<node TEXT="Lanza excepci&#xf3;n si no encuentra" ID="ID_797742407" CREATED="1573061328187" MODIFIED="1573061339430"/>
</node>
<node TEXT="refresh()" FOLDED="true" ID="ID_833013184" CREATED="1573061699040" MODIFIED="1573061702088">
<node TEXT="Actualiza el objeto persistente con los datos de la base de datos" ID="ID_1946487401" CREATED="1573061702948" MODIFIED="1573061716595"/>
</node>
</node>
<node TEXT="Detached -&gt; Persistent" FOLDED="true" ID="ID_1767188323" CREATED="1573055336476" MODIFIED="1573055341187">
<node TEXT="saveOrUpdate()" FOLDED="true" ID="ID_1568164581" CREATED="1573055345811" MODIFIED="1573055348169">
<node TEXT="Guarda como nuevo si no existe" ID="ID_271110788" CREATED="1573061413973" MODIFIED="1573061424208"/>
<node TEXT="Modifica si existe" ID="ID_1078578722" CREATED="1573061424390" MODIFIED="1573061427848"/>
</node>
<node TEXT="lock()" ID="ID_910981699" CREATED="1573055348316" MODIFIED="1573055350577"/>
<node TEXT="replicate()" ID="ID_916549108" CREATED="1573055351592" MODIFIED="1573055353723"/>
<node TEXT="persistent = merge(detached)" FOLDED="true" ID="ID_1813312311" CREATED="1573055358509" MODIFIED="1573061369325">
<node TEXT="El objeto pasado queda Detached" ID="ID_642034258" CREATED="1573061379505" MODIFIED="1573061385061"/>
</node>
<node TEXT="update(detachedConvertidoAPersistent)" ID="ID_1018759976" CREATED="1573055342292" MODIFIED="1573061397204"/>
</node>
<node TEXT="isDirty()" FOLDED="true" ID="ID_1680185443" CREATED="1573061958568" MODIFIED="1573061967567">
<node TEXT="Comprobar si hay cambios pendientes de persistir" ID="ID_93201369" CREATED="1573061967971" MODIFIED="1573061974788"/>
</node>
</node>
<node TEXT="Configuraci&#xf3;n" POSITION="right" ID="ID_548133285" CREATED="1573132433418" MODIFIED="1573132435442">
<edge COLOR="#00007c"/>
<node TEXT="class" ID="ID_206516426" CREATED="1573131451704" MODIFIED="1573132433423">
<font BOLD="true"/>
<node TEXT="Atributos" FOLDED="true" ID="ID_1691103783" CREATED="1573131844811" MODIFIED="1573131879534">
<node TEXT="name" ID="ID_214463279" CREATED="1573131491009" MODIFIED="1573131542310">
<font BOLD="true"/>
<node TEXT="Clase" ID="ID_544273335" CREATED="1573139277229" MODIFIED="1573139278573"/>
</node>
<node TEXT="table" ID="ID_1583909867" CREATED="1573131491952" MODIFIED="1573131519861">
<font ITALIC="true"/>
<node TEXT="Nombre de clase a secas" ID="ID_32392840" CREATED="1573131522593" MODIFIED="1573131545873">
<font ITALIC="true"/>
</node>
</node>
<node TEXT="discriminator-value" ID="ID_1775557623" CREATED="1573131493124" MODIFIED="1573131520956">
<font ITALIC="true"/>
<node TEXT="Nombre de clase a secas" ID="ID_170092525" CREATED="1573131522593" MODIFIED="1573131545873">
<font ITALIC="true"/>
</node>
<node TEXT="Para subclases" ID="ID_30703985" CREATED="1573131576751" MODIFIED="1573131589636"/>
</node>
<node TEXT="dynamic-update" ID="ID_1391558994" CREATED="1573131596528" MODIFIED="1573131613227">
<font ITALIC="true"/>
<node TEXT="false" ID="ID_1035839380" CREATED="1573131616034" MODIFIED="1573131617620">
<font ITALIC="true"/>
</node>
<node TEXT="Si true, s&#xf3;lo columnas cambiadas" ID="ID_1993108228" CREATED="1573131641198" MODIFIED="1573131646305"/>
</node>
<node TEXT="dynamic-insert" ID="ID_1976269025" CREATED="1573131599918" MODIFIED="1573131613226">
<font ITALIC="true"/>
<node TEXT="false" ID="ID_65299600" CREATED="1573131618378" MODIFIED="1573131621353">
<font ITALIC="true"/>
</node>
<node TEXT="Si true, s&#xf3;lo columnas sin valores null" ID="ID_1610401035" CREATED="1573131641198" MODIFIED="1573131660069"/>
</node>
<node TEXT="optimistic-lock" ID="ID_1352953502" CREATED="1573131606861" MODIFIED="1573131613226">
<font ITALIC="true"/>
<node TEXT="version" ID="ID_1166784600" CREATED="1573131622087" MODIFIED="1573131625580">
<font ITALIC="true"/>
</node>
<node TEXT="none" ID="ID_1474223461" CREATED="1573131713939" MODIFIED="1573131715710"/>
<node TEXT="dirty" ID="ID_1776730537" CREATED="1573131715851" MODIFIED="1573131718000"/>
<node TEXT="all" ID="ID_1994332350" CREATED="1573131718143" MODIFIED="1573131719107"/>
</node>
<node TEXT="lazy" ID="ID_1935753615" CREATED="1573131727536" MODIFIED="1573131729065">
<font ITALIC="true"/>
<node TEXT="true" ID="ID_1164256193" CREATED="1573131729883" MODIFIED="1573131755820">
<font ITALIC="true"/>
<node ID="ID_1523531290" CREATED="1573131739876" MODIFIED="1573131750656"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      <i>Para resultados directos</i>
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Antes todo true" ID="ID_1056172462" CREATED="1573131776168" MODIFIED="1573139689380">
<font BOLD="true"/>
</node>
<node TEXT="Cambi&#xf3; por JPA" ID="ID_1137113465" CREATED="1573131779609" MODIFIED="1573131785044"/>
</node>
<node TEXT="false" ID="ID_55301396" CREATED="1573131733670" MODIFIED="1573131739126">
<font ITALIC="true"/>
<node TEXT="Para resultados indirectos" ID="ID_801354399" CREATED="1573131761714" MODIFIED="1573131767830">
<font ITALIC="true"/>
</node>
</node>
</node>
<node TEXT="..." ID="ID_1079783310" CREATED="1573131852031" MODIFIED="1573131853331"/>
</node>
<node TEXT="id" FOLDED="true" ID="ID_1029821541" CREATED="1573131444223" MODIFIED="1573131541566">
<font BOLD="true"/>
<node TEXT="generator class" ID="ID_1905532920" CREATED="1573131255752" MODIFIED="1573131444231">
<node TEXT="assigned" ID="ID_1387649392" CREATED="1573131281439" MODIFIED="1573132235345">
<font BOLD="true"/>
<node TEXT="Se toma el id proporcionado" ID="ID_752515927" CREATED="1573132239486" MODIFIED="1573132260033"/>
<node TEXT="No se autogenera" ID="ID_1076010447" CREATED="1573132263190" MODIFIED="1573132265443"/>
</node>
<node TEXT="increment" ID="ID_1071229053" CREATED="1573131261978" MODIFIED="1573131278958">
<node TEXT="No vale para cluster" ID="ID_529673111" CREATED="1573132194088" MODIFIED="1573132197626"/>
</node>
<node TEXT="identity" ID="ID_325754035" CREATED="1573131279170" MODIFIED="1573140412058">
<font BOLD="false"/>
<node TEXT="DB2" ID="ID_484559602" CREATED="1573132199652" MODIFIED="1573140164773">
<font BOLD="true"/>
</node>
<node TEXT="MySQL" ID="ID_311937846" CREATED="1573132289178" MODIFIED="1573132291003"/>
<node TEXT="MS SQL" ID="ID_727577082" CREATED="1573132291118" MODIFIED="1573140165850">
<font BOLD="true"/>
</node>
<node TEXT="Sybase" ID="ID_425047711" CREATED="1573132292889" MODIFIED="1573132295450"/>
<node TEXT="HypersonicSQL" ID="ID_1039480388" CREATED="1573132295592" MODIFIED="1573132299743"/>
<node TEXT="..." ID="ID_603019694" CREATED="1573140179214" MODIFIED="1573140181598"/>
</node>
<node TEXT="native" ID="ID_884775121" CREATED="1573132164302" MODIFIED="1573140412824">
<font BOLD="false"/>
<node TEXT="Depende de la base de datos" ID="ID_124326275" CREATED="1573132304563" MODIFIED="1573140419991">
<font BOLD="true"/>
<node TEXT="identity" ID="ID_506596437" CREATED="1573132315342" MODIFIED="1573140416465">
<font BOLD="true"/>
</node>
<node TEXT="sequence" ID="ID_920384243" CREATED="1573132317997" MODIFIED="1573132320683"/>
<node TEXT="hilo" ID="ID_1867263948" CREATED="1573132320825" MODIFIED="1573132321768"/>
</node>
</node>
<node TEXT="uuid" ID="ID_1449535886" CREATED="1573131299064" MODIFIED="1573132338662">
<node TEXT="Id autogenerado" ID="ID_632302097" CREATED="1573132342616" MODIFIED="1573132354567"/>
</node>
<node TEXT="hilo" ID="ID_153096471" CREATED="1573132146927" MODIFIED="1573132147904"/>
</node>
</node>
<node TEXT="property" FOLDED="true" ID="ID_1953477583" CREATED="1573131911813" MODIFIED="1573131914887">
<node TEXT="name" ID="ID_529410208" CREATED="1573131921628" MODIFIED="1573131969332">
<font BOLD="true" ITALIC="false"/>
<node TEXT="Nombre de la propiedad con inicial en min&#xfa;scula" ID="ID_179172912" CREATED="1573131944719" MODIFIED="1573131967643">
<font BOLD="true" ITALIC="false"/>
</node>
</node>
<node TEXT="column" ID="ID_1803614561" CREATED="1573131925823" MODIFIED="1573131976112">
<font ITALIC="true"/>
<node TEXT="Igual que name" ID="ID_423794015" CREATED="1573131976430" MODIFIED="1573131986178">
<font ITALIC="true"/>
</node>
</node>
<node TEXT="unique" ID="ID_941951577" CREATED="1573131992460" MODIFIED="1573131995690">
<font ITALIC="true"/>
<node TEXT="false" ID="ID_1805527353" CREATED="1573131996871" MODIFIED="1573132006095">
<font ITALIC="true"/>
</node>
</node>
<node TEXT="not-null" ID="ID_841842421" CREATED="1573131927040" MODIFIED="1573132025198">
<font ITALIC="true"/>
<node TEXT="false" ID="ID_1485580788" CREATED="1573132018763" MODIFIED="1573132022993">
<font ITALIC="true"/>
</node>
</node>
<node TEXT="type" ID="ID_420728871" CREATED="1573131922809" MODIFIED="1573140603095">
<font ITALIC="true"/>
<node TEXT="Tipo hibernate" ID="ID_617403694" CREATED="1573140631108" MODIFIED="1573140635632"/>
</node>
<node TEXT="length" ID="ID_1344071397" CREATED="1573140698744" MODIFIED="1573140703040">
<font ITALIC="true"/>
</node>
<node TEXT="precision" ID="ID_118981962" CREATED="1573140716655" MODIFIED="1573140718824">
<font ITALIC="true"/>
</node>
<node TEXT="scale" ID="ID_138019375" CREATED="1573140724928" MODIFIED="1573140726402">
<font ITALIC="true"/>
</node>
<node TEXT="optimistic-lock" ID="ID_804727246" CREATED="1573132031290" MODIFIED="1573132039480">
<font ITALIC="true"/>
<node TEXT="true" ID="ID_561875909" CREATED="1573132035284" MODIFIED="1573132038368">
<font ITALIC="true"/>
</node>
</node>
<node TEXT="generated" ID="ID_627415301" CREATED="1573132091320" MODIFIED="1573132096587">
<font ITALIC="true"/>
<node TEXT="never" ID="ID_102645540" CREATED="1573132093856" MODIFIED="1573132096587">
<font ITALIC="true"/>
</node>
<node TEXT="insert" ID="ID_782159896" CREATED="1573132104409" MODIFIED="1573132105339"/>
<node TEXT="always" ID="ID_77645421" CREATED="1573132105477" MODIFIED="1573132106571"/>
</node>
<node TEXT="update" ID="ID_1008403055" CREATED="1573131923808" MODIFIED="1573140604260">
<font ITALIC="true"/>
</node>
<node TEXT="insert" ID="ID_335931724" CREATED="1573131924740" MODIFIED="1573140608002">
<font ITALIC="true"/>
</node>
<node TEXT="..." ID="ID_1502990312" CREATED="1573140734489" MODIFIED="1573140735233"/>
</node>
<node TEXT="one-to-one" ID="ID_1699677206" CREATED="1573144511246" MODIFIED="1573144514635">
<node TEXT="name" ID="ID_1772512318" CREATED="1573144518631" MODIFIED="1573144520290">
<node TEXT="Propiedad en clase principal" ID="ID_314557922" CREATED="1573144532525" MODIFIED="1573144549830"/>
</node>
<node TEXT="class" ID="ID_1195519011" CREATED="1573144522738" MODIFIED="1573144523675">
<node TEXT="Clase relacionada (tipo)" ID="ID_329300226" CREATED="1573144551438" MODIFIED="1573144561894"/>
</node>
<node TEXT="cascade" ID="ID_772407452" CREATED="1573144568429" MODIFIED="1573144569868">
<node TEXT="save-update" ID="ID_1350654413" CREATED="1573144572802" MODIFIED="1573144575033"/>
</node>
<node TEXT="constrained" ID="ID_1330612527" CREATED="1573144591862" MODIFIED="1573144593701">
<node TEXT="true" ID="ID_709247462" CREATED="1573144594230" MODIFIED="1573144595032">
<node TEXT="En la secundaria" ID="ID_1802652948" CREATED="1573144630210" MODIFIED="1573144633447"/>
</node>
<node TEXT="false" ID="ID_1969406251" CREATED="1573144595152" MODIFIED="1573144596010"/>
</node>
</node>
</node>
</node>
<node TEXT="Referencias" POSITION="left" ID="ID_1832116492" CREATED="1573144407474" MODIFIED="1573144409124">
<edge COLOR="#007c7c"/>
<node ID="ID_881893948" CREATED="1573144431871" MODIFIED="1573144431871" LINK="https://docs.jboss.org/hibernate/orm/current/quickstart/html_single/"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <a href="https://docs.jboss.org/hibernate/orm/current/quickstart/html_single/">https://docs.jboss.org/hibernate/orm/current/quickstart/html_single/</a>
  </body>
</html>

</richcontent>
</node>
<node ID="ID_1064592417" CREATED="1573144449179" MODIFIED="1573144449179" LINK="https://www.mkyong.com/"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <a href="https://www.mkyong.com/">https://www.mkyong.com/</a>
  </body>
</html>

</richcontent>
</node>
<node ID="ID_563049390" CREATED="1573144461366" MODIFIED="1573144461366" LINK="https://www.baeldung.com/"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <a href="https://www.baeldung.com/">https://www.baeldung.com/</a>
  </body>
</html>

</richcontent>
</node>
</node>
</node>
</map>
