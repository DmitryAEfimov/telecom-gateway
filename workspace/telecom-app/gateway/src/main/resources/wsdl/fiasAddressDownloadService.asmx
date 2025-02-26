<wsdl:definitions xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="https://fias.nalog.ru/WebServices/Public/DownloadService.asmx/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" targetNamespace="https://fias.nalog.ru/WebServices/Public/DownloadService.asmx/" name="IDownloadService">
	<wsdl:types>
		<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" elementFormDefault="qualified" targetNamespace="https://fias.nalog.ru/WebServices/Public/DownloadService.asmx/">
			<xs:import namespace="http://schemas.microsoft.com/2003/10/Serialization/Arrays"/>
			<xs:import namespace="http://schemas.datacontract.org/2004/07/System"/>
			<xs:element name="GetAllDownloadFileInfo">
				<xs:complexType>
					<xs:sequence/>
				</xs:complexType>
			</xs:element>
			<xs:element name="GetAllDownloadFileInfoResponse">
				<xs:complexType>
					<xs:sequence>
						<xs:element minOccurs="0" maxOccurs="1" name="GetAllDownloadFileInfoResult" nillable="true" type="tns:ArrayOfDownloadFileInfo"/>
					</xs:sequence>
				</xs:complexType>
			</xs:element>
			<xs:element name="GetLastDownloadFileInfo">
				<xs:complexType>
					<xs:sequence/>
				</xs:complexType>
			</xs:element>
			<xs:element name="GetLastDownloadFileInfoResponse">
				<xs:complexType>
					<xs:sequence>
						<xs:element minOccurs="0" maxOccurs="1" name="GetLastDownloadFileInfoResult" type="tns:DownloadFileInfo"/>
					</xs:sequence>
				</xs:complexType>
			</xs:element>
			<xs:complexType name="ArrayOfDownloadFileInfo">
				<xs:sequence>
					<xs:element minOccurs="0" maxOccurs="unbounded" nillable="true" name="DownloadFileInfo" type="tns:DownloadFileInfo"/>
				</xs:sequence>
			</xs:complexType>
			<xs:element name="ArrayOfDownloadFileInfo" nillable="true" type="tns:ArrayOfDownloadFileInfo"/>
			<xs:complexType name="DownloadFileInfo">
				<xs:sequence>
					<xs:element minOccurs="1" maxOccurs="1" name="VersionId" type="xs:long"/>
					<xs:element minOccurs="0" maxOccurs="1" name="TextVersion" type="xs:string"/>
					<xs:element minOccurs="0" maxOccurs="1" name="FiasCompleteDbfUrl" type="xs:string"/>
					<xs:element minOccurs="0" maxOccurs="1" name="FiasCompleteXmlUrl" type="xs:string"/>
					<xs:element minOccurs="0" maxOccurs="1" name="FiasDeltaDbfUrl" type="xs:string"/>
					<xs:element minOccurs="0" maxOccurs="1" name="FiasDeltaXmlUrl" type="xs:string"/>
					<xs:element minOccurs="0" maxOccurs="1" name="Kladr4ArjUrl" type="xs:string"/>
					<xs:element minOccurs="0" maxOccurs="1" name="Kladr47ZUrl" type="xs:string"/>
				</xs:sequence>
			</xs:complexType>
			<xs:element name="DownloadFileInfo" nillable="true" type="tns:DownloadFileInfo"/>
		</xs:schema>
	</wsdl:types>
	<wsdl:message name="IDownloadService_GetAllDownloadFileInfo_InputMessage">
		<wsdl:part name="parameters" element="tns:GetAllDownloadFileInfo"/>
	</wsdl:message>
	<wsdl:message name="IDownloadService_GetAllDownloadFileInfo_OutputMessage">
		<wsdl:part name="parameters" element="tns:GetAllDownloadFileInfoResponse"/>
	</wsdl:message>
	<wsdl:message name="IDownloadService_GetLastDownloadFileInfo_InputMessage">
		<wsdl:part name="parameters" element="tns:GetLastDownloadFileInfo"/>
	</wsdl:message>
	<wsdl:message name="IDownloadService_GetLastDownloadFileInfo_OutputMessage">
		<wsdl:part name="parameters" element="tns:GetLastDownloadFileInfoResponse"/>
	</wsdl:message>
	<wsdl:portType name="IDownloadService">
		<wsdl:operation name="GetAllDownloadFileInfo">
			<wsdl:input message="tns:IDownloadService_GetAllDownloadFileInfo_InputMessage"/>
			<wsdl:output message="tns:IDownloadService_GetAllDownloadFileInfo_OutputMessage"/>
		</wsdl:operation>
		<wsdl:operation name="GetLastDownloadFileInfo">
			<wsdl:input message="tns:IDownloadService_GetLastDownloadFileInfo_InputMessage"/>
			<wsdl:output message="tns:IDownloadService_GetLastDownloadFileInfo_OutputMessage"/>
		</wsdl:operation>
	</wsdl:portType>
	<wsdl:binding name="BasicHttpBinding_IDownloadService" type="tns:IDownloadService">
		<soap:binding transport="http://schemas.xmlsoap.org/soap/http"/>
		<wsdl:operation name="GetAllDownloadFileInfo">
			<soap:operation soapAction="https://fias.nalog.ru/WebServices/Public/DownloadService.asmx/GetAllDownloadFileInfo" style="document"/>
			<wsdl:input>
				<soap:body use="literal"/>
			</wsdl:input>
			<wsdl:output>
				<soap:body use="literal"/>
			</wsdl:output>
		</wsdl:operation>
		<wsdl:operation name="GetLastDownloadFileInfo">
			<soap:operation soapAction="https://fias.nalog.ru/WebServices/Public/DownloadService.asmx/GetLastDownloadFileInfo" style="document"/>
			<wsdl:input>
				<soap:body use="literal"/>
			</wsdl:input>
			<wsdl:output>
				<soap:body use="literal"/>
			</wsdl:output>
		</wsdl:operation>
	</wsdl:binding>
	<wsdl:service name="IDownloadService">
		<wsdl:port name="BasicHttpBinding_IDownloadService" binding="tns:BasicHttpBinding_IDownloadService">
			<soap:address location="http://fias.nalog.ru/WebServices/Public/DownloadService.asmx"/>
		</wsdl:port>
	</wsdl:service>
</wsdl:definitions>